package com.xiezhiheng.shadowsocks.event;

import com.xiezhiheng.shadowsocks.Session;
import com.xiezhiheng.shadowsocks.ShadowsocksLocal;
import com.xiezhiheng.shadowsocks.log.Logger;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author xiezhiheng
 */
public class ReadEventHandler implements EventHandler<ReadEvent> {
	private final ByteBuffer buffer = ByteBuffer.allocate(32 * 1024);

	@Override
	public void handle(ShadowsocksLocal shadowsocksLocal, ReadEvent event) {
		buffer.clear();
		SelectionKey key = event.getKey();
		SocketChannel channel = (SocketChannel) key.channel();
		Session session = (Session) key.attachment();
		try {
			int size = channel.read(session.getReadBuffer());
			if (size < 0) {

			}
		} catch (IOException e) {
			Logger.error(e);
		}

	}
}
