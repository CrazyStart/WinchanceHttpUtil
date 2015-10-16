package asynctask;



/**
 * 被观察者
 * @ClassName: ProgressCallable
 * @version 1.0
 * @param <T>
 */
public interface ProgressCallable<T> {

	/**
	 * 注册观察者对象
	 * @param pProgressListener
	 * @return
	 * @throws Exception
	 */
	public T call(final IProgressListener pProgressListener) throws Exception;
}