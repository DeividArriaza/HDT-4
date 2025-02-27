public interface IList<T> {
    /* 
     * @param data: information of the list type
     * @return: String representation of the list type
    */
    String getTypeList(String data);

    void add(T item);
}
