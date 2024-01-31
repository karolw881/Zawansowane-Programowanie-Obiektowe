class Result implements Comparable<Result> {
    int score;
    int time;

    public Result(int score, int time) {
        this.score = score;
        this.time = time;
    }

    @Override
    public int compareTo(Result other) {
        double thisValue = this.score * 0.5 + this.time * 0.5;
        double otherValue = other.score * 0.5 + other.time * 0.5;
        return Double.compare(otherValue, thisValue);
    }
}