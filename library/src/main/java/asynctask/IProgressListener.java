package asynctask;


/**
 * 观察者
 * @version 1.0.0
 */
public interface IProgressListener {

	/**
	 * 进度发生改变的时候调用
	 * @param pProgress progress
	 */
	public void onProgressChanged(final int pProgress);
}