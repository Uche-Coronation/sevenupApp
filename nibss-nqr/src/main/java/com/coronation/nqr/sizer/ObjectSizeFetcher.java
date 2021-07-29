package com.coronation.nqr.sizer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectSizeFetcher {
	
	public static long  getObjectSize(Object o) throws IOException {
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      ObjectOutputStream oos = new ObjectOutputStream(bos);
	      oos.writeObject(o);
	      oos.flush();
	      byte [] data = bos.toByteArray();
	      return data.length;
	}
	
}
	
