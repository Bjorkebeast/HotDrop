package com.bjorkebeast.hotdrop;

import net.minecraft.dispenser.ProxyBlockSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.*;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEventHandler {

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {

        if ( event.getEntity().getEntityWorld().isRemote ){

            return;
        }

        LivingEntity subject = event.getEntityLiving();

        if ( ! (subject instanceof MobEntity) ){

            return;
        }

        MobEntity mob = (MobEntity)subject;

        if ( !mob.hasCustomName() ){

            return;
        }

        ItemStack drop = new ItemStack( Items.NAME_TAG );

        drop.setDisplayName( mob.getCustomName() );
        drop.setRepairCost( 0 );

        ItemEntity item = new ItemEntity( subject.world, subject.posX, subject.posY, subject.posZ );
        item.entityDropItem( drop );
    }
}

