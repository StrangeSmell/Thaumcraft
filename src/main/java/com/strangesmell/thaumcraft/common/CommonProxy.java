package com.strangesmell.thaumcraft.common;

import com.strangesmell.thaumcraft.api.aspects.AspectList;
import com.strangesmell.thaumcraft.common.lib.research.PlayerKnowledge;
import com.strangesmell.thaumcraft.common.lib.research.ResearchManager;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Map;

public class CommonProxy {
    public PlayerKnowledge playerKnowledge;
    public ResearchManager researchManager;
    //public WandManager wandManager = new WandManager();
    public CommonProxy() {
    }
    public PlayerKnowledge getPlayerKnowledge() {
        return this.playerKnowledge;
    }

    public ResearchManager getResearchManager() {
        return this.researchManager;
    }

    public Map<String, ArrayList<String>> getCompletedResearch() {
        return this.playerKnowledge.researchCompleted;
    }

    public Map<String, ArrayList<String>> getScannedObjects() {
        return this.playerKnowledge.objectsScanned;
    }

    public Map<String, ArrayList<String>> getScannedEntities() {
        return this.playerKnowledge.entitiesScanned;
    }

    public Map<String, ArrayList<String>> getScannedPhenomena() {
        return this.playerKnowledge.phenomenaScanned;
    }

    public Map<String, AspectList> getKnownAspects() {
        return this.playerKnowledge.aspectsDiscovered;
    }

    public void registerDisplayInformation() {
    }

    public void registerHandlers() {
    }

    public Object getClientGuiElement(int ID, Player player, Level world, int x, int y, int z) {
        return null;
    }

/*    public Object getServerGuiElement(int ID, Player player, Level world, int x, int y, int z) {
        switch(ID) {
            case 0:
                return new ContainerGolem(player.field_71071_by, ((EntityGolemBase)((WorldServer)world).func_73045_a(x)).inventory);
            case 1:
                return new ContainerPech(player.field_71071_by, world, (EntityPech)((WorldServer)world).func_73045_a(x));
            case 2:
                return new ContainerTravelingTrunk(player.field_71071_by, world, (EntityTravelingTrunk)((WorldServer)world).func_73045_a(x));
            case 3:
                return new ContainerThaumatorium(player.field_71071_by, (TileThaumatorium)world.func_147438_o(x, y, z));
            case 4:
            case 6:
            case 7:
            case 11:
            case 12:
            case 14:
            default:
                return null;
            case 5:
                return new ContainerFocusPouch(player.field_71071_by, world, x, y, z);
            case 8:
                return new ContainerDeconstructionTable(player.field_71071_by, (TileDeconstructionTable)world.func_147438_o(x, y, z));
            case 9:
                return new ContainerAlchemyFurnace(player.field_71071_by, (TileAlchemyFurnace)world.func_147438_o(x, y, z));
            case 10:
                return new ContainerResearchTable(player.field_71071_by, (TileResearchTable)world.func_147438_o(x, y, z));
            case 13:
                return new ContainerArcaneWorkbench(player.field_71071_by, (TileArcaneWorkbench)world.func_147438_o(x, y, z));
            case 15:
                return new ContainerArcaneBore(player.field_71071_by, (TileArcaneBore)world.func_147438_o(x, y, z));
            case 16:
                return new ContainerHandMirror(player.field_71071_by, world, x, y, z);
            case 17:
                return new ContainerHoverHarness(player.field_71071_by, world, x, y, z);
            case 18:
                return new ContainerMagicBox(player.field_71071_by, (TileMagicBox)world.func_147438_o(x, y, z));
            case 19:
                return new ContainerSpa(player.field_71071_by, (TileSpa)world.func_147438_o(x, y, z));
            case 20:
                return new ContainerFocalManipulator(player.field_71071_by, (TileFocalManipulator)world.func_147438_o(x, y, z));
        }
    }*/

    public Level getClientLevel() {
        return null;
    }

    public void blockSparkle(Level Level, int x, int y, int z, int i, int count) {
    }

    public void sparkle(float x, float y, float z, float size, int color, float gravity) {
    }

    public void sparkle(float x, float y, float z, int color) {
    }

    //???
    //public void crucibleBoil(Level Level, int xCoord, int yCoord, int zCoord, TileCrucible tile, int j) {}

    public void crucibleBoilSound(Level Level, int xCoord, int yCoord, int zCoord) {
    }

    public void crucibleBubble(Level Level, float x, float y, float z, float cr, float cg, float cb) {
    }

    public int particleCount(int base) {
        return 0;
    }

    public void wispFX(Level LevelObj, double posX, double posY, double posZ, float f, float g, float h, float i) {
    }

    public void sourceStreamFX(Level LevelObj, double sx, double sy, double sz, float tx, float ty, float tz, int tag) {
    }

    public void bolt(Level LevelObj, Entity sourceEntity, Entity targetedEntity) {
    }

    public void furnaceLavaFx(Level LevelObj, int x, int y, int z, int facingX, int facingZ) {
    }

    public void wispFX2(Level LevelObj, double posX, double posY, double posZ, float size, int type, boolean shrink, boolean clip, float gravity) {
    }

    public void crucibleFroth(Level Level, float x, float y, float z) {
    }

    public void crucibleFrothDown(Level Level, float x, float y, float z) {
    }

    public Object beamCont(Level LevelObj, Player pm, double tx, double ty, double tz, int type, int color, boolean reverse, float endmod, Object input, int impact) {
        return null;
    }

    public void excavateFX(int x, int y, int z, Player p, int bi, int md, int progress) {
    }

    public void burst(Level LevelObj, double sx, double sy, double sz, float size) {
    }

    public void wispFX3(Level LevelObj, double posX, double posY, double posZ, double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity) {
    }

    public void smokeSpiral(Level m, double x, double y, double z, float rad, int start, int miny, int color) {
    }

    public void beam(Level LevelObj, double sx, double sy, double sz, double tx, double ty, double tz, int type, int color, boolean reverse, float endmod, int impact) {
    }

    public void blockRunes(Level Level, double x, double y, double z, float r, float g, float b, int dur, float grav) {
    }

    public Object beamBore(Level LevelObj, double px, double py, double pz, double tx, double ty, double tz, int type, int color, boolean reverse, float endmod, Object input, int impact) {
        return null;
    }

    public void boreDigFx(Level LevelObj, int x, int y, int z, int x2, int y2, int z2, Block bi, int md) {
    }

    public void soulTrail(Level Level, Entity source, Entity target, float r, float g, float b) {
    }

    public void nodeBolt(Level LevelObj, float x, float y, float z, Entity targetedEntity) {
    }

    public void splooshFX(Entity e) {
    }

    public void tentacleAriseFX(Entity e) {
    }

    public void slimeJumpFX(Entity e, int i) {
    }

    public void dropletFX(Level Level, float i, float j, float k, float r, float g, float b) {
    }

    public void taintLandFX(Entity e) {
    }

    public Object swarmParticleFX(Level LevelObj, Entity targetedEntity, float f1, float f2, float pg) {
        return null;
    }

    public void taintsplosionFX(Entity e) {
    }

    //???
    //public IIcon getIcon(String string) {return null;}

    public void registerCustomIcons() {
    }

    public void hungryNodeFX(Level LevelObj, int tx, int ty, int tz, int xCoord, int yCoord, int zCoord, Block block, int md) {
    }

    public void essentiaTrailFx(Level LevelObj, int x, int y, int z, int x2, int y2, int z2, int count, int color, float scale) {
    }

    public void splooshFX(Level LevelObj, int x, int y, int z) {
    }

    public void nodeBolt(Level LevelObj, float x, float y, float z, float x2, float y2, float z2) {
    }

    public void drawInfusionParticles1(Level LevelObj, double x, double y, double z, int x2, int y2, int z2, Item bi, int md) {
    }

    public void drawInfusionParticles2(Level LevelObj, double x, double y, double z, int x2, int y2, int z2, Block bi, int md) {
    }

    public void drawInfusionParticles3(Level LevelObj, double x, double y, double z, int x2, int y2, int z2) {
    }

    public void drawInfusionParticles4(Level LevelObj, double x, double y, double z, int x2, int y2, int z2) {
    }

    public void drawVentParticles(Level LevelObj, double x, double y, double z, double x2, double y2, double z2, int color) {
    }

    public void blockWard(Level Level, double x, double y, double z, Direction side, float f, float f1, float f2) {
    }

    public void wispFX4(Level LevelObj, double posX, double posY, double posZ, Entity target, int type, boolean shrink, float gravity) {
    }

    public void registerKeyBindings() {
    }

    public Object beamPower(Level LevelObj, double px, double py, double pz, double tx, double ty, double tz, float r, float g, float b, boolean pulse, Object input) {
        return null;
    }

    public boolean isShiftKeyDown() {
        return false;
    }

    public void wispFXEG(Level LevelObj, double posX, double posY, double posZ, Entity target) {
    }

    public void reservoirBubble(Level LevelObj, int xCoord, int yCoord, int zCoord, int color) {
    }

    public void spark(float x, float y, float z, float size, float r, float g, float b, float a) {
    }

    public void drawVentParticles(Level LevelObj, double x, double y, double z, double x2, double y2, double z2, int color, float scale) {
    }

    public void bottleTaintBreak(Level Level, double x, double y, double z) {
    }

    public void drawGenericParticles(Level LevelObj, double x, double y, double z, double x2, double y2, double z2, float r, float g, float b, float alpha, boolean loop, int start, int num, int inc, int age, int delay, float scale) {
    }

    public void arcLightning(Level Level, double x, double y, double z, double tx, double ty, double tz, float r, float g, float b, float h) {
    }

}
