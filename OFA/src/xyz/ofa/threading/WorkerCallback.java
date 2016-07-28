package xyz.ofa.threading;

public interface WorkerCallback<K> {
	public void workComplete(K data);
}
