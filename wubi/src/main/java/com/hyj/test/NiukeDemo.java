package com.hyj.test;

public class NiukeDemo {
    public static void main(String[] args) {
        String s = "25S-abc-d";
//        System.out.println(test("abcd", new StringBuilder("")));

        System.out.println(test2(new int[]{1, 5,7}));
    }

    /**
     * 字符串2个2个切割,
     */
    public static StringBuilder test(CharSequence charSequence, StringBuilder target) {
        if (charSequence.length() > 2) {
            CharSequence charSequence1 = charSequence.subSequence(0, 2);
            target.append(charSequence1).append("-");
            test(charSequence.subSequence(2, charSequence.length()), target);
        } else {
            return target.append(charSequence);
        }
        return target;
    }

    /**
     * 1 2 3 5 7 8       1-3,5,7-8
     * 0 1 2 3 4 5
     * 思路:
     * 连,数字加线;再想办法去掉中间的
     * 不连;数字加逗号,
     * 最后一个,单独连在最后,不加线,也不加逗号,
     */
    public static StringBuilder test2(int[] intArr) {
        StringBuilder target = new StringBuilder();
        if (intArr.length == 1) {
            return target.append(intArr[0]);
        } else if (intArr.length == 2) {
            if (intArr[0] + 1 == intArr[1]) {
                return target.append(intArr[0] + "-" + intArr[1]);
            } else {
                return target.append(intArr[0] + "," + intArr[1]);
            }
        }
        if (intArr.length >= 3) {
            boolean lineIsAdded = false;
            for (int i = 0; i < intArr.length - 1; i++) {
                if (intArr[i] + 1 == intArr[i + 1]) {
                    if (lineIsAdded == false) {
                        target.append(intArr[i] + "-");
                        lineIsAdded = true;
                    } else {
                        target.append("");
                    }
                    continue;
                } else {
                    target.append(intArr[i] + ",");
                    if (lineIsAdded) {
                        lineIsAdded = !lineIsAdded;
                    }
                    //上一步只拼一个逗号,这里可以开启下一个元素
                    continue;
                }

            }
        }
        target.append(intArr[intArr.length - 1]);
        return target;
    }

    /**
     * 字码压缩技术,
     * 输入[time,me,bell] .输出time#bell# index=[0,2,5],利用index的元素到#结束,恢复原数组
     */
    public static void test3() {
        
    }
}
