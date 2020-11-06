public class ArrayList<T>
{
    private T[] asArray;

    public ArrayList(){
        asArray = (T[]) new Object[0];
    }

    public void add(T t){
        T[] temp = (T[]) new Object[asArray.length + 1];

        for (int i = 0; i < asArray.length; i++){
            temp[i] = asArray[i];
        }

        temp[asArray.length] = t;
        asArray = temp;
    }

    public void remove(int index){
        if (index < 0 || index >= asArray.length) return;
        T[] temp = (T[]) new Object[asArray.length - 1];

        boolean found = false;
        for (int i = 0; i < asArray.length; i++){
            if (i == index){
                found = true;
                continue;
            }
            temp[i - (found ? 1 : 0)] = asArray[i];
        }
        asArray = temp;
    }
        
    public T get(int index){
        return asArray[index];
    }
    
    public int size(){
        return asArray.length;
    }
}