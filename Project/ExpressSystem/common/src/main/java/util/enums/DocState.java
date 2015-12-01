package util.enums;

public enum DocState {
    UNCHECKED(0), // 未审批
    FAILED(1), //不通过
    PASSED(2);//通过

    private int intState;

    DocState(int i) {
        this.intState = i;
    }

    public int getIntState() {
        return intState;
    }

    public static DocState getDocState(int i) {
        for (DocState state : values()) {
            if (state.intState == i)
                return state;
        }
        return null;
    }
}
