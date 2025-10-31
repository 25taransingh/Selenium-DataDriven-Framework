# 🧪 Data Driven Testing Framework (Selenium + TestNG + Apache POI)

This project demonstrates a **Data Driven Automation Framework** built with **Selenium WebDriver**, **TestNG**, and **Apache POI**.
It reads test data from an Excel file and executes the same test case with multiple data sets dynamically.

---

## 🚀 Features

✅ Data-driven testing using Excel (Apache POI)
✅ Integration with TestNG `@DataProvider`
✅ Modular Maven project structure
✅ Reusable and scalable test design
✅ Easy to extend with WebDriver for UI testing

---

## 🧩 Tech Stack

| Component         | Technology         |
| ----------------- | ------------------ |
| Language          | Java               |
| Automation Tool   | Selenium WebDriver |
| Testing Framework | TestNG             |
| Build Tool        | Maven              |
| Data Handling     | Apache POI         |
| IDE               | Eclipse / IntelliJ |

---

## 📁 Project Structure

```
datadriven/
├── src/
│   └── test/java/datadriven/datadriven.java
├── excelDriven.xlsx
├── pom.xml
└── testng.xml (optional)
```

---

## ⚙️ How It Works

1. Excel file (`excelDriven.xlsx`) contains input data (e.g., greetings, messages, IDs).
2. Apache POI reads data and stores it into a **2D Object array**.
3. TestNG’s `@DataProvider` supplies this data to the test method.
4. Test method executes once for each row of Excel data.

---

## 🧠 Example Code Snippet

```java
@DataProvider(name = "driveTest")
public Object[][] getData() throws IOException {
    FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\excelDriven.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheetAt(0);
    int rowCount = sheet.getPhysicalNumberOfRows();
    XSSFRow row = sheet.getRow(0);
    int colCount = row.getLastCellNum();

    Object data[][] = new Object[rowCount - 1][colCount];
    DataFormatter formatter = new DataFormatter();

    for (int i = 0; i < rowCount - 1; i++) {
        row = sheet.getRow(i + 1);
        for (int j = 0; j < colCount; j++) {
            XSSFCell cell = row.getCell(j);
            data[i][j] = formatter.formatCellValue(cell);
        }
    }
    wb.close();
    fis.close();
    return data;
}
```

---

## 🧾 Example Excel Data

| greeting | communication | id  |
| -------- | ------------- | --- |
| Hello    | Email         | 101 |
| Hi       | Call          | 102 |

**Output:**

```
Hello Email 101
Hi Call 102
```

---

## ▶️ How to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/<your-username>/Selenium-DataDriven-Framework.git
   ```

2. Import as **Maven Project** into Eclipse or IntelliJ.

3. Update your Excel file path if needed.

4. Run the test as **TestNG Test**.

---

## 🧱 Future Enhancements

* Integrate Selenium WebDriver for live UI automation
* Add Extent Reports for visual reporting
* Implement Page Object Model (POM) structure
* Jenkins CI/CD pipeline setup

---

## 💬 Author

👤 **Taran Singh**
📧 writetotaransingh@gmail.com
💻 Passionate about Test Automation and Framework Design
