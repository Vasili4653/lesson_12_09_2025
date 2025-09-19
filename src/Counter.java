public class Counter {

    volatile int value;// можно писать перед любым свойством класса


    public void incValue(){
        // объектом синхронизации может являться
        // любой наследник класса Object
        synchronized (this) {
            // весь код внутри блока может принадлежать только одному потоку в один момент
            // при обращении к нему другого потока, он станет в очередь
            value++;
        }
    }

    public synchronized void decValue(){// здесь mutex(semaphore) может быть только this
        value--;
    }

    public void run(){
        System.out.println("Running...");
        synchronized (this){
            try {
                this.wait();// блокирует выполнение потока
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Finished");
    }
}
