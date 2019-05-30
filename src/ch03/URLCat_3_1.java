package ch03;

import java.io.InputStream;
import java.net.URL;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class URLCat_3_1 {
	static {
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
	public static void main(String[] args) throws Exception{
		InputStream in = null;
		try{
			in = new URL(args[0]).openStream();
			IOUtils.copyBytes(in, System.out,4096,false);
		}finally{
			IOUtils.closeStream(in);
		}
	}
}
