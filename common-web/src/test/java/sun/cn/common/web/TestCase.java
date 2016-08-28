package sun.cn.common.web;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestCase {
	
	private ExecutorService testExecutors = Executors.newFixedThreadPool(2);
	
	@Test
	public void threadTest(){
		for(int i = 0;i<10;i++){
			final int k = i;
			testExecutors.submit(new Runnable() {
				
				@Override
				public void run() {
					while(true){
					System.out.println("thread name is "+k);
					try {
						if(k == 0 || k==1)
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					}
				}
			});
		}
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
