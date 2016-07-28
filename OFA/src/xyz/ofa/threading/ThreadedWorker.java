package xyz.ofa.threading;

import java.util.ArrayList;
import java.util.List;

public abstract class ThreadedWorker<T, K> implements Runnable {
	protected Thread thread = new Thread(this);

	protected T data;
	protected long startTime;
	protected long executionTime;
	protected boolean gaveCallback = false;
	private List<WorkerCallback<K>> callbacks = new ArrayList<>();

	public void startWorker() {
		thread.setName("worker-" + this.thread.hashCode());
		gaveCallback = false;
		thread.start();
		startTime = System.currentTimeMillis();
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
		executionTime = System.currentTimeMillis() - startTime;
		gaveCallback = true;
		for (WorkerCallback<K> cb : callbacks) {
			cb.workComplete(data);
		}
	}
	public long getElapsedTime(){
		return System.currentTimeMillis() - startTime;
	}
	public long getExecutionTime() {
		if (gaveCallback)
			return executionTime;
		else
			return -1;
	}

	public void addInputData(T data) {
		this.data = data;
	}
}
