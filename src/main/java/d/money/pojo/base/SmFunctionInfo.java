package d.money.pojo.base;

public class SmFunctionInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sm_function_info.function_id
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    private String functionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sm_function_info.function_code
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    private String functionCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sm_function_info.function_name
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    private String functionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sm_function_info.function_description
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    private String functionDescription;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sm_function_info.parent_function
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    private String parentFunction;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sm_function_info.function_id
     *
     * @return the value of sm_function_info.function_id
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public String getFunctionId() {
        return functionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sm_function_info.function_id
     *
     * @param functionId the value for sm_function_info.function_id
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public void setFunctionId(String functionId) {
        this.functionId = functionId == null ? null : functionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sm_function_info.function_code
     *
     * @return the value of sm_function_info.function_code
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public String getFunctionCode() {
        return functionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sm_function_info.function_code
     *
     * @param functionCode the value for sm_function_info.function_code
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sm_function_info.function_name
     *
     * @return the value of sm_function_info.function_name
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sm_function_info.function_name
     *
     * @param functionName the value for sm_function_info.function_name
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sm_function_info.function_description
     *
     * @return the value of sm_function_info.function_description
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public String getFunctionDescription() {
        return functionDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sm_function_info.function_description
     *
     * @param functionDescription the value for sm_function_info.function_description
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public void setFunctionDescription(String functionDescription) {
        this.functionDescription = functionDescription == null ? null : functionDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sm_function_info.parent_function
     *
     * @return the value of sm_function_info.parent_function
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public String getParentFunction() {
        return parentFunction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sm_function_info.parent_function
     *
     * @param parentFunction the value for sm_function_info.parent_function
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    public void setParentFunction(String parentFunction) {
        this.parentFunction = parentFunction == null ? null : parentFunction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_function_info
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SmFunctionInfo other = (SmFunctionInfo) that;
        return (this.getFunctionId() == null ? other.getFunctionId() == null : this.getFunctionId().equals(other.getFunctionId()))
            && (this.getFunctionCode() == null ? other.getFunctionCode() == null : this.getFunctionCode().equals(other.getFunctionCode()))
            && (this.getFunctionName() == null ? other.getFunctionName() == null : this.getFunctionName().equals(other.getFunctionName()))
            && (this.getFunctionDescription() == null ? other.getFunctionDescription() == null : this.getFunctionDescription().equals(other.getFunctionDescription()))
            && (this.getParentFunction() == null ? other.getParentFunction() == null : this.getParentFunction().equals(other.getParentFunction()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_function_info
     *
     * @mbggenerated Thu Feb 26 17:58:47 CST 2015
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFunctionId() == null) ? 0 : getFunctionId().hashCode());
        result = prime * result + ((getFunctionCode() == null) ? 0 : getFunctionCode().hashCode());
        result = prime * result + ((getFunctionName() == null) ? 0 : getFunctionName().hashCode());
        result = prime * result + ((getFunctionDescription() == null) ? 0 : getFunctionDescription().hashCode());
        result = prime * result + ((getParentFunction() == null) ? 0 : getParentFunction().hashCode());
        return result;
    }
}