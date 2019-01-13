# coding=utf-8
import xlrd
import MySQLdb

book = xlrd.open_workbook(u"/home/mobvoi/Downloads/微信公众号.xlsx")
sheet = book.sheet_by_index(1)

# 建立mysql连接
database = MySQLdb.connect(host='127.0.0.1', user='root', passwd='******', db='pitaya', port=3306,
                           use_unicode=True, charset="utf8")
# 获得游标对象, 用于逐行遍历数据库数据
cursor = database.cursor()
# 创建插入SQL语句
query = """
		insert into tag_main (name,domain,level,parent_id) values(%s,%s,%s,%s)
		"""

quer1 = """select id from tag_main where name = %s"""

def excel_insert_data():
    i = 0
    listh = []
    # 创建一个for循环迭代读取xls文件每行数据的, 从第二行开始是要跳过标题
    for rx in range(0, sheet.ncols, 2):
        id = i
        uri = sheet.cell(1, rx).value
        values = (uri, "public_account", "1", "0")
        cursor.execute(query, values)
        i = i + 1
        listh.append(uri)

    for rx in range(1,sheet.ncols,2):
        id2 = i
        for e in range(1,sheet.nrows,1):

            tag_name = sheet.cell(e,rx).value
            if tag_name in listh:
                break
            pa = sheet.cell(1,rx -1).value
            cursor.execute("select id from tag_main where name ='%s'" % pa)
            parent_id = cursor.fetchone()
            va = (tag_name,"public_account","2",parent_id)
            cursor.execute(query,va)
            i = i + 1
            listh.append(tag_name)


def excel_close():
    # 关闭游标
    cursor.close()

    # 提交
    database.commit()

    # 关闭数据库连接
    database.close()


def main():
    excel_insert_data()
    excel_close()
    print u"Done!恭喜"


if __name__ == "__main__":
    main()
