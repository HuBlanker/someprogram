#! /bin/bash
num=$1
echo $num
money=0
while (( $num!=0 ))
do
  num=`expr $num / 5`
  money=`expr $money + $num`
done
echo $money

