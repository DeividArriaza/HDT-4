public interface IList<T>{
    /* 
     * @param data: information of the list type
     * @return: String representation of the list type
     */
    String getTypeList(String data);

    /*
     * @param item: item to be added to the list
     * @return: void
     */ 
    void add(T item);

    /*
     * @return: eliminated item from the list or null if the list is empty
     */
    T remove();

    /*
     * @return: true if the list is empty, false otherwise
     */
    boolean isEmpty();
}
