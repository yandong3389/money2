package d.money.common.exception;

public class BaseException extends Exception {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /** 异常 */
    private Throwable original = null;

    /** 错误信息 */
    private String errorMsg = null;

    /**
     * 构造函数
     * 
     * @param e
     *            异常
     */
    public BaseException(Throwable e, String errorMsg) {
        this.original = e;
        this.errorMsg = errorMsg;
    }

    /**
     * 构造函数
     * 
     * @param msg
     *            message信息
     */
    public BaseException(String msg) {
        this.errorMsg = msg;
    }

    /**
     * 取得异常对象
     * 
     * @return 异常
     */
    public Throwable getOriginal() {
        return original;
    }

    /**
     * 设定异常对象
     * 
     * @param original
     *            异常对象
     */
    protected void setOriginal(Throwable original) {
        this.original = original;
    }

    /**
     * 取得错误信息
     * 
     * @return 错误信息
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 设定错误信息
     * 
     * @param errorMsg
     *            错误信息
     */
    protected void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
