package demo;

/**
 * @author 河南张国荣
 * @create 2021-07-11 13:16
 */
public enum Season {
    Spring("春"),
    Summer("夏"),
    Autumn("秋"),
    Winter("冬");

    private String desc;

    Season(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
