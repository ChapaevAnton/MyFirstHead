package com.example.myfirsthead;

import android.util.Log;

public class WorkOut {
    //region variables
    private static final String TAG ="TAG" ;
    private final String name;
    private final String description;
    public static WorkOut[] workOut;
    private final static String[] mas_name = {"Автомобиль", "Мотоцикл", "Велосипед"};
    private final static String[] mas_description = {"Быстрый ", "Громкий", "Удобный"};
    //endregion

    //region constructor
    private WorkOut() {
        this("title","description" );
    }

    /**
     * @param name название транспорта
     * @param description описание транспорта
     */
    private WorkOut(String name, String description) {
        this.name = name;
        this.description = description;
    }
    //endregion

    //region set
    //OPTIMIZE: Переработать иницилизацию и цикл
    // - добавил только конструктор WorkOut() в обработку исключения

    public static void setWorkOuts() {
        WorkOut[] workOuts = new WorkOut[mas_name.length];
        for (int i = 0; i < workOuts.length; i++) {
            try {
                workOuts[i] = new WorkOut(mas_name[i], mas_description[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                workOuts[i]=new WorkOut();
                Log.d(TAG, "setWorkOuts: workOuts["+i+"]->"+workOuts[i]);
                Log.d(TAG, "setWorkOuts:"+e);
            }
        }
        workOut=workOuts;
    }
    //endregion

    //region get
    public String getName() { return name; }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
    //endregion
}
