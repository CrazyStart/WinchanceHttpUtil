package asynctask;


/**
 * 观察者
 * @ClassName: IProgressListener
 * @version 1.0
 */
public interface IProgressListener {

	/**
	 * 进度发生改变的时候调用
	 * @param pProgress
	 */
	public void onProgressChanged(final int pProgress);
}