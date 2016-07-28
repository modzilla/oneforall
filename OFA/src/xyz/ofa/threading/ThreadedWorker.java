package xyz.ofa.threading;

import java.util.ArrayList;
import java.util.List;

public abstract class ThreadedWorker<T, K> implements Runnable {
	protected Thread thread = new Thread(this);

	protected T data;
	private List<WorkerCallback<K>> callbacks = new ArrayList<>();

	public void startWorker() {
		thread.start();
	}

	public void interruptWorker() {
		thread.interrupt();
	}

	public Thread getThread() {
		return thread;
	}

	public boolean hasData() {
		return data != null;
	}

	public boolean hasCallback() {
		return callbacks.size() > 0;
	}

	public void addCallback(WorkerCallback<K> callback) {
		callbacks.add(callback);
	}

	public void invokeCallback(K data) {
		for (WorkerCallback<K> cb : callbacks) {
			cb.workComplete(data);
		}
	}

	public void addInputData(T data) {
		this.data = data;
	}
}
