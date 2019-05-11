package com.huyan.lucenedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.charset.CoderResult.OVERFLOW;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuceneDemoApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void testFileUpWather() throws IOException {
		// 说明，这里的监听也必须是目录
		Path path = Paths.get("/tmp");
		WatchService watcher = FileSystems.getDefault().newWatchService();
		path.register(watcher, ENTRY_MODIFY);

		new Thread(() -> {
			try {
				while (true) {
					WatchKey key = watcher.take();
					for (WatchEvent<?> event : key.pollEvents()) {
						if (event.kind() == OVERFLOW) {
							//事件可能lost or discarded
							continue;
						}
						Path fileName = (Path) event.context();
						System.out.println("文件更新: " + fileName);
					}
					if (!key.reset()) { // 重设WatchKey
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();


		try {
			Thread.sleep(1000 * 60 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
