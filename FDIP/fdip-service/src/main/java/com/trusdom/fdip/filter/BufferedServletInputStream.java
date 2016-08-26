package com.trusdom.fdip.filter;
import java.io.*;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

/*
Subclass of ServletInputStream needed by the servlet engine.
All inputStream methods are wrapped and are delegated to
the ByteArrayInputStream (obtained as constructor parameter)!
 */
public class BufferedServletInputStream extends ServletInputStream {

	ByteArrayInputStream bais;

	public BufferedServletInputStream(ByteArrayInputStream bais) {
		this.bais = bais;
	}

	public int available() {
		return bais.available();
	}

	public int read() {
		return bais.read();
	}

	public int read(byte[] buf, int off, int len) {
		return bais.read(buf, off, len);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletInputStream#isFinished()
	 */
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletInputStream#isReady()
	 */
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletInputStream#setReadListener(javax.servlet.ReadListener)
	 */
	@Override
	public void setReadListener(ReadListener readListener) {
		// TODO Auto-generated method stub
		
	}

}