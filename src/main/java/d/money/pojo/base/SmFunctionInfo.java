package d.money.pojo.base;

public class SmFunctionInfo {
    private String functionId;

    private String functionCode;

    private String functionName;

    private String functionDescription;

    private String parentFunction;

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId == null ? null : functionId.trim();
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getFunctionDescription() {
        return functionDescription;
    }

    public void setFunctionDescription(String functionDescription) {
        this.functionDescription = functionDescription == null ? null : functionDescription.trim();
    }

    public String getParentFunction() {
        return parentFunction;
    }

    public void setParentFunction(String parentFunction) {
        this.parentFunction = parentFunction == null ? null : parentFunction.trim();
    }

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