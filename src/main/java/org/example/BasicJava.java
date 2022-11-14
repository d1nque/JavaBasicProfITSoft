package org.example;

import org.example.figure.Figure3D;

import java.util.*;
import java.util.Map.Entry;

public class BasicJava {

    /**
     * Метод возвращающий целые отсортированые числа
     * по убываныю используя stream, Collections
     * @param - integerArrayList входящий массив целых чисел
     * @return - отсортированый массив позитивных чисел
     */
    public ArrayList<Integer> onlyPositiveNumbers(ArrayList<Integer> integerArrayList){
        if(integerArrayList == null) {
            throw new NullPointerException("Array cant be null");
        }
            return new ArrayList<>(integerArrayList.stream()
                    .filter(v -> v >= 0)
                    .sorted(Collections.reverseOrder())
                    .toList());

    }

    /**
     *
     * @param someStrings рядки з хештегами
     * @return
     */
    public Map<String, Integer> getTopFiveHashtags(ArrayList<String> someStrings){
        if(someStrings == null){
            throw new NullPointerException("Can`t be null");
        }
        Map<String, Integer> hashtagsMap = new HashMap<>();
        String[] temporarySplitedString;
        ArrayList<String> temporaryStringArray = new ArrayList<>();
        for(int i = 0; i < someStrings.size(); i++){
            temporarySplitedString = someStrings.get(i).toLowerCase().split(" ");

            for (int j = 0; j < temporarySplitedString.length; j++){
                if(temporarySplitedString[j].startsWith("#") && !temporaryStringArray.contains(temporarySplitedString[j])){
                    temporaryStringArray.add(temporarySplitedString[j]);

                    if(hashtagsMap.containsKey(temporarySplitedString[j]))
                        hashtagsMap.put(temporarySplitedString[j], hashtagsMap.get(temporarySplitedString[j]) + 1);
                    else
                        hashtagsMap.put(temporarySplitedString[j], 1);
                }
            }
            temporaryStringArray.clear();
        }


        LinkedHashMap<String, Integer> topFiveHashtags = new LinkedHashMap<>();
        List<Entry<String, Integer>> temporaryListForSorting = new LinkedList<>(hashtagsMap.entrySet());
        Collections.sort(temporaryListForSorting, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        //Возвращаю просто 5 первых елементов из отсортированого листа
        int arraySizeLimit = Math.min(temporaryListForSorting.size(), 5);
        if(arraySizeLimit > 0) {
            for(int i = 0; i < arraySizeLimit;i++){
                topFiveHashtags.put(temporaryListForSorting.get(i).getKey(), temporaryListForSorting.get(i).getValue());
            }
        }

        return topFiveHashtags;

    }

    /**
     *
     * @param figures
     * @return
     */
    public ArrayList<Figure3D> getSort3DFigures(ArrayList<Figure3D> figures){
        if(figures == null){
            throw new NullPointerException("Cant be null");
        }
        figures.sort((o1, o2) -> (int)(o2.getVolume() - o1.getVolume()));

        return figures;
    }




}
