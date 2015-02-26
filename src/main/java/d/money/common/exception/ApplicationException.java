package d.money.common.exception;

public class ApplicationException extends BaseException {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 构造函数
     * 
     * @param e
     *            异常
     */
    public ApplicationException(Throwable e, String message) {
        super(e, message);
        super.setOriginal(e);
    }

    /**
     * 构造函数
     * 
     * @param msg
     *            message信息
     */
    public ApplicationException(String msg) {
        super(msg);
        super.setErrorMsg(msg);
    }
}
