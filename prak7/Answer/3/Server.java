import java.util.ArrayList;

public class Server {
	// nWorkers menyatakan jumlah maximum threads yang tersedia pada server a.k.a
	// thread pool
	private int workers;
	private Thread[] threads;

	Server(int workers) {
		// Lengkapi kode berikut
		this.workers = workers;
		this.threads = new Thread[workers];
	}

	public Integer[] process(String[] requests) throws InterruptedException {
		// process akan membuat threads dan memetakan elemen-elemen requests kepada
		// threads tersebut
		// setiap thread kemudian memanggil method count
		// main thread (thread yang invoked method ini) akan menunggu semua thread
		// selesai
		// terakhir main thread akan mengembalikan hasil penghitungan kata untuk setiap
		// elemen requests
		// Lengkapi kode berikut

		Integer[] retval = new Integer[requests.length];

		int load = requests.length;
		int start = 0;
		int end;

		if (load > 0) {
			for (int i = 0; i < workers; i++) {
				end = start + (int) load / (workers - i);

				final int tmpstart = start;
				final int tmpend = end;

				threads[i] = new Thread(new Runnable() {
					public void run() {
						try {
							for (int j = tmpstart; j < tmpend; j++) {
								retval[j] = count(requests[j]);
							}
						} 
						catch (Exception e) {
						}
					}
				});

				threads[i].start();

				load = load - (end - start);
				start = end;
			}

			for (int i = 0; i < workers; i++) {
				try {
					threads[i].join();
				} 
				catch (Exception e) {
				}
			}
		}

		return retval;
	}

	protected int count(String request) {
		// Lengkapi kode berikut
		if (request.length() == 0)
			return 0;

		String[] words = {};
		words = request.trim().split("\\s+");
		return words.length;
	}
}
