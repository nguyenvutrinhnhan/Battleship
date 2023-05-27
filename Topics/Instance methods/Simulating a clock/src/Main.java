class Clock {
    public static final int RESET_HOUR = 13;
    public static final int RESET_MINUTE = 60;
    public static final int DEFAULT_HOUR = 12;
    public static final int DEFAULT_MINUTE = 0;
    int hours = DEFAULT_HOUR;
    int minutes = DEFAULT_MINUTE;

    void next() {
        // implement me
        if (++this.minutes == RESET_MINUTE) {
            this.minutes = 0;
            if (++this.hours == RESET_HOUR) {
                this.hours = 1;
            }
        }
    }

    @Override
    public String toString() {
        return "time is " + String.format("%02d", this.hours) + ":" + String.format("%02d", this.minutes);
    }
}