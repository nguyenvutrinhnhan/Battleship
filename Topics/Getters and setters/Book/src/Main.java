class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String[] getAuthors() {
        return this.authors.clone();
    }

    public void setAuthors(String[] authors) {
        if (authors != null) {
            this.authors = authors.clone();
        }
    }
}