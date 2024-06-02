package com.strangesmell.thaumcraft.client.lib;

import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.common.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerNotifications {
    public static ArrayList<Notification> notificationList = new ArrayList();
    public static ArrayList<PlayerNotifications.AspectNotification> aspectList = new ArrayList();

    public PlayerNotifications() {
    }

    public static void addNotification(String text) {
        addNotification(text, (ResourceLocation)null, 16777215);
    }

    public static void addAspectNotification(Aspect aspect) {
        long time = System.nanoTime() / 1000000L + (long) Minecraft.getInstance().level.random.nextInt(1000);
        float x = 0.4F + Minecraft.getInstance().level.random.nextFloat() * 0.2F;
        float y = 0.4F + Minecraft.getInstance().level.random.nextFloat() * 0.2F;
        aspectList.add(new PlayerNotifications.AspectNotification(aspect, x, y, time, time + 1500L));
    }

    public static void addNotification(String text, Aspect aspect) {
        addNotification(text, aspect.getImage(), aspect.getColor());
    }

    public static void addNotification(String text, ResourceLocation image) {
        addNotification(text, image, 16777215);
    }

    public static void addNotification(String text, ResourceLocation image, int color) {
        long time = System.nanoTime() / 1000000L;
        long timeBonus = notificationList.size() == 0 ? (long)(Config.notificationDelay / 2) : 0L;
        notificationList.add(new PlayerNotifications.Notification(text, image, time + (long)Config.notificationDelay + timeBonus, time + (long)(Config.notificationDelay / 4), color));
    }

    public static ArrayList<PlayerNotifications.Notification> getListAndUpdate(long time) {
        ArrayList<PlayerNotifications.Notification> temp = new ArrayList();
        boolean first = true;

        for(Iterator i$ = notificationList.iterator(); i$.hasNext(); first = false) {
            PlayerNotifications.Notification li = (PlayerNotifications.Notification)i$.next();
            if (li.expire >= time) {
                if (!first) {
                    temp.add(new PlayerNotifications.Notification(li.text, li.image, time + (long)Config.notificationDelay, li.created, li.color));
                } else {
                    temp.add(li);
                }
            }
        }

        notificationList = temp;
        return temp;
    }

    public static ArrayList<PlayerNotifications.AspectNotification> getAspectListAndUpdate(long time) {
        ArrayList<PlayerNotifications.AspectNotification> temp = new ArrayList();
        Iterator i$ = aspectList.iterator();

        while(i$.hasNext()) {
            PlayerNotifications.AspectNotification li = (PlayerNotifications.AspectNotification)i$.next();
            if (li.expire >= time) {
                temp.add(li);
            }
        }

        aspectList = temp;
        return temp;
    }

    public static class AspectNotification {
        public Aspect aspect;
        public float startX;
        public float startY;
        public long expire;
        public long created;

        public AspectNotification(Aspect aspect, float startX, float startY, long created, long expire) {
            this.aspect = aspect;
            this.startX = startX;
            this.startY = startY;
            this.expire = expire;
            this.created = created;
        }
    }

    public static class Notification {
        public String text;
        public ResourceLocation image;
        public long expire;
        public long created;
        public int color;

        public Notification(String text, ResourceLocation image, long expire, long created, int color) {
            this.text = text;
            this.image = image;
            this.expire = expire;
            this.created = created;
            this.color = color;
        }
    }
}
