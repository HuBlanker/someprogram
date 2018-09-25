#! /bin/bash
num=$1
echo $num
result=0
while (( $num!=0 ))
do
  num=`expr $num / 5`
  result=`expr $result + $num`
done
echo $result

