package class01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;

import java.nio.file.Paths;


public class CopyFile_by_IO {

	public static void copyfileByNIO(String path){
		
		File f= new File(path);
		
		try (	FileChannel inChannel=new FileInputStream(f).getChannel();
				
				FileOutputStream outputStream=new FileOutputStream(new File("NIO.txt"));
				FileChannel outChannel=outputStream.getChannel();
						){
//			inChannel.tryLock();
			MappedByteBuffer buff=inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			
			Charset chartset=Charset.forName("GBK");
//			MappedByteBuffer byteBuffer=chartset.encode(buff);
			outChannel.write(buff);
			buff.clear();
			inChannel.close();
			outChannel.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	
	
		
		
		
	}
	
	public static void copyfileByNIO2(String path) throws FileNotFoundException, IOException{
		
		try {
			Files.copy(Paths.get(path), new FileOutputStream("NIO2.txt"));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		 long timeStar_one = System.currentTimeMillis();
		copyfileByNIO("result.txt");
		 long timeEnd_one = System.currentTimeMillis();
		 
		 System.out.println("NIO run:"+String.valueOf(timeEnd_one-timeStar_one)+" ms");
		 
		 long timeStar_two = System.currentTimeMillis();
		 copyfileByNIO2("result.txt");
			 long timeEnd_two = System.currentTimeMillis();
			 
			 System.out.println("NIO2 run:"+String.valueOf(timeEnd_two-timeStar_two)+"ms");
			 
	}

}
