package nur.p3.qa;

public class TestOrdenado {
    public static void main(String[] args) {
        int [] a  = {7,2,4,8,3,9,1,5,10,6};
        int menor;

        for(int i = 0; i < 10; i++){
            menor = a[0];

            if (a[i] < menor){
                menor = a[i];
            }
            else{
                if (a[i] > menor){
                    menor = menor;
                }
            }
        }
    }

    /**
     * Formula de complejidad O(n) = n^2
     * @param A
     */
    public static void insercionDirecta(int A[]){
        int p, j;
        int aux;
        for (p = 1; p < A.length; p++){ // desde el segundo elemento hasta
            aux = A[p];           // el final, guardamos el elemento y
            j = p - 1;            // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el
                // valor de aux sea menor que los
                A[j + 1] = A[j];   // de la izquierda, se desplaza a
                j--;               // la derecha
            }
            A[j + 1] = aux;       // colocamos aux en su sitio
        }
    }

    /**
     * COmplejidad de quicksort O(n log n)
     * @param A
     */
    public static void quicksort(int A[]) {

    }
}
