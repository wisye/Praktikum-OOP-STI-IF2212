public class NumberSumII {
    public Number sumNumberII(Number[] numArr) {
        Number[] sum = {0};
        for (Number number : numArr) {
            if(number instanceof Integer){
                boolean pos = number.intValue() > 0;
                sum[0] = sum[0].intValue() + number.intValue();
                if(pos && sum[0].intValue() < 0){
                    sum[0] = Integer.MAX_VALUE;
                }
                else if(!pos && sum[0].intValue() > 0){
                    sum[0] = Integer.MIN_VALUE;
                }
            }
            else if(number instanceof Double){
                Double n = sum[0].doubleValue() + number.doubleValue();
                sum[0] = n;
                if(sum[0].doubleValue() == Double.POSITIVE_INFINITY){
                    sum[0] = Double.MAX_VALUE;
                }
                else if(sum[0].doubleValue() == Double.NEGATIVE_INFINITY){
                    sum[0] = Double.MIN_VALUE;
                }
            }
            else if(number instanceof Byte){
                boolean pos = number.byteValue() > 0;
                Byte n = (byte) (sum[0].byteValue() + number.byteValue());
                sum[0] = n;
                if(pos && sum[0].byteValue() < 0){
                    sum[0] = Byte.MAX_VALUE;
                }
                else if(!pos && sum[0].byteValue() > 0){
                    sum[0] = Byte.MIN_VALUE;
                }
            }
            else if(number instanceof Float){
                Float n = sum[0].floatValue() + number.floatValue();
                sum[0] = n;
                if(sum[0].floatValue() == Float.POSITIVE_INFINITY){
                    sum[0] = Float.MAX_VALUE;
                }
                else if(sum[0].floatValue() == Float.NEGATIVE_INFINITY){
                    sum[0] = Float.MIN_VALUE;
                }
            }
            else if(number instanceof Long){
                boolean pos = number.longValue() > 0;
                Long n = sum[0].longValue() + number.longValue();
                sum[0] = n;
                if(pos && sum[0].longValue() < 0){
                    sum[0] = Long.MAX_VALUE;
                }
                else if(!pos && sum[0].longValue() > 0){
                    sum[0] = Long.MIN_VALUE;
                }
            }
            else if(number instanceof Short){
                boolean pos = number.shortValue() > 0;
                Short n = (short) (sum[0].shortValue() + number.shortValue());
                sum[0] = n;
                if(pos && sum[0].shortValue() < 0){
                    sum[0] = Short.MAX_VALUE;
                }
                else if(!pos && sum[0].shortValue() > 0){
                    sum[0] = Short.MIN_VALUE;
                }
            }
        }
        return sum[0];
    }
    // public static void main(String[] args){
    //     NumberSumII n = new NumberSumII();
    //     Number[] num = {1, 2, 3, 4, 5.2};

    //     System.out.println(n.sumNumberII(num));
    // }
}
