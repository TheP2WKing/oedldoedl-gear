package net.thep2wking.oedldoedlgear.content.tile;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileTransparentReplacement extends TileEntity implements ITickable {
	private int timer;
	private IBlockState originalState;
	private static final int SECONDS = 30;

	public TileTransparentReplacement() {
		super();
		timer = 0;
		originalState = Blocks.AIR.getDefaultState();
	}

	public void setOriginalState(IBlockState state) {
		this.originalState = state;
	}

	@Override
	public void update() {
		timer++;
		if (timer > 20 * SECONDS) {
			world.setBlockState(pos, originalState);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.timer = compound.getInteger("timer");
		this.originalState = Block.getBlockById(compound.getInteger("originalState")).getDefaultState();
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("timer", this.timer);
		compound.setInteger("originalState", Block.getIdFromBlock(originalState.getBlock()));
		return compound;
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		NBTTagCompound tag = pkt.getNbtCompound();
		this.readFromNBT(tag);
	}

	public int getSeconds() {
		return this.timer / 20;
	}

	public int getMaxSeconds() {
		return SECONDS;
	}
}