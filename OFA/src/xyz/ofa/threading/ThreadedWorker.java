package xyz.ofa.threading;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kenny Kropp
 * A general 1 Input, 1 Output threaded worker
 * @param <T> Input type
 * @param <K> Output type
 */
public abstract class ThreadedWorker<T, K> implements Runnable {
	protected Thread thread = new Thread(this);

	protected T data;
	protected long startTime;
	protected long executionTime;
	protected boolean gaveCallback = false;
	private List<WorkerCallback<K>> callbacks = new ArrayList<>();
	
	/**
	 * Start the worker <b>use this method</b> to start the worker
	 * if you want to use any of the timing functions
	 */
	public void startWorker() {
		thread.setName("worker-" + this.thread.hashCode());
		gaveCallback = false;
		thread.start();
		startTime = System.currentTimeMillis();
	}
	/**
	 * Sends an interrupt to the WorkerThread
	 */
	public void interruptWorker() {
		thread.interrupt();
	}
	/**
	 * Gets the underlying Thread
	 * @return The underlying Thread
	 */
	public Thread getThread() {
		return thread;
	}
	/**
	 * Returns true if Data has been loaded into the Worker
	 * @return true if {@link ThreadedWorker#addInputData(Object)} has been called and the data was not null
	 */
	public boolean hasData() {
		return data != null;
	}
	/**
	 * @return true if there is a callback attached
 	 */
	public boolean hasCallback() {
		return callbacks.size() > 0;
	}
	/**
	 * Adds a callback
	 * @param callback The Callback with the type of the Output data
	 */
	public void addCallback(WorkerCallback<K> callback) {
		callbacks.add(callback);
	}
	/**
	 * Invokes to all Callbacks that the task has been completed
	 * @param data The data to send to the Callbacks
	 */
	public void invokeCallback(K data) {
		executionTime = System.currentTimeMillis() - startTime;
		gaveCallback = true;
		for (WorkerCallback<K> cb : callbacks) {
			cb.workComplete(data);
		}
	}
	/**
	 * Get the time since the execution in ms
	 * @return Time since execution in milliseconds
	 */
	public long getElapsedTime(){
		return System.currentTimeMillis() - startTime;
	}
	/**
	 * Get the time in milliseconds from {@link ThreadedWorker#startWorker()} until {@link ThreadedWorker#invokeCallback(Object)}
	 * @return Time in milliseconds
	 */
	public long getExecutionTime() {
		if (gaveCallback)
			return executionTime;
		else
			return -1;
	}
	/**
	 * Load data into the Worker
	 * @param data Input data
	 */
	public void addInputData(T data) {
		this.data = data;
	}
}
