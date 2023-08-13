/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.impl.networking;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.login.LoginQueryRequestPayload;
import net.minecraft.network.packet.s2c.login.LoginQueryRequestS2CPacket;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.impl.networking.payload.PacketByteBufLoginQueryRequestPayload;
import net.fabricmc.fabric.impl.networking.payload.PayloadHelper;

public class LoginQueryRequestS2CPacketFactory {
	public static LoginQueryRequestS2CPacket create(PacketByteBuf buf) {
		int queryId = buf.readVarInt();
		Identifier identifier = buf.readIdentifier();
		return new LoginQueryRequestS2CPacket(queryId, readPayload(identifier, buf));
	}

	private static LoginQueryRequestPayload readPayload(Identifier id, PacketByteBuf buf) {
		return new PacketByteBufLoginQueryRequestPayload(id, PayloadHelper.read(buf));
	}
}