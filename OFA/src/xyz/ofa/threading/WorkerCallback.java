package xyz.ofa.threading;

/**
 * @author Kenny Kropp
 *
 * @param <K> Output data type of the ThreadedWorker
 */
public interface WorkerCallback<K> {
	/**
	 * The worker has completed, here is the data
	 * @param data Output data
	 */
	public void workComplete(K data);
}
