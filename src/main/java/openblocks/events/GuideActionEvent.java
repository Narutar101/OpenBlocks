package openblocks.events;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import openmods.events.network.BlockEventPacket;
import openmods.network.event.EventDirection;
import openmods.network.event.NetworkEventMeta;

@NetworkEventMeta(direction = EventDirection.C2S)
public class GuideActionEvent extends BlockEventPacket {

	public String command;

	public GuideActionEvent() {}

	public GuideActionEvent(int dimension, BlockPos pos, String event) {
		super(dimension, pos);
		this.command = event;
	}

	@Override
	protected void readFromStream(PacketBuffer input) {
		super.readFromStream(input);
		this.command = input.readStringFromBuffer(0xFFFF);
	}

	@Override
	protected void writeToStream(PacketBuffer output) {
		super.writeToStream(output);
		output.writeString(this.command);
	}

}
