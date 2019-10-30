// 标题:
//      组合两个表

// 描述:
//表1: Person 
//
// +-------------+---------+
//| 列名         | 类型     |
//+-------------+---------+
//| PersonId    | int     |
//| FirstName   | varchar |
//| LastName    | varchar |
//+-------------+---------+
//PersonId 是上表主键
// 
//
// 表2: Address 
//
// +-------------+---------+
//| 列名         | 类型    |
//+-------------+---------+
//| AddressId   | int     |
//| PersonId    | int     |
//| City        | varchar |
//| State       | varchar |
//+-------------+---------+
//AddressId 是上表主键
// 
//
// 
//
// 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息： 
//
// 
//
// FirstName, LastName, City, State
// 
//

// 思路:

/**
 * Created by huyanshi on 
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode175{
//       public static void main(String[] args) {
//            Solution solution = new LeetCode175().new Solution();
//      }


// My Code End


//select FirstName,LastName, City,State from Person as p left job Address as a on p.PersionId = a.PersonId


}
