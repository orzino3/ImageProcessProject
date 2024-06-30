חברי הקבוצה הם:
חברי הקבוצה מיכאל ווקנין, אסתר אסרף, שקד אטדגי, אור זינו, אודיה נאמן


הוראות פרויקט לעיבוד תמונה

מטרה: 
מטרת פרויקט זה היא ליצור אפליקציית Swing המאפשרת למשתמשים לטעון תמונה מהמחשב שלהם, להציג אותה על המסך, ולהחיל עליה מניפולציות שונות באמצעות כפתורים ואינטראקציה עם העכבר. 

תיאור: 
מיד עם הרצת התוכנית, אמור להופיע למשתמש חלון ובו כפתור עם הטקסט "פתח תמונה". כפתור זה יאפשר למשתמש לבחור תמונה מהמחשב שלו (אם תרצו לאפשר למשתמש להקליד את נתיב התמונה בתוך תיבת טקסט – גם זה אפשרי). 
לאחר בחירת התמונה, היא אמורה להיות מוצגת בחלון הראשי. 

מתחת לתמונה המוצגת (או לצדה), יהיו מספר כפתורים או תפריטי בחירה, עבור המניפולציות השונות הניתנות לביצוע. 

עליכם לממש את המניפולציות הבאות לפחות 10 מבין המניפולציות הבאות: 
-Black-White – תמונה המורכבת אך ורק משחור מלא ומלבן מלא.  
-Grayscale: תמונה בגווני שחור לבן.
-Posterize: הפחתת מספר הגוונים בתמונה ובכך לשוות לה אפקט של תמונת פוסטר.
-Tint: הוספת גוון לתמונה (בחרו גוון קבוע כרצונכם)
-Color Shift Right: R->G, G->B, B->R
-Color Shift Left: R->B, G->R, B->G
-Mirror: הצגת תמונת מראה
-Pixelate: יצירת אפקט של תמונה מפוקסלת, על ידי הפחתת הרזולוציה שלה
-Show Borders: הבלטת כל הגבולות המופיעים בתוך התמונה
-Eliminate Red/Green/Blue: ביטול אחד מצבעי היסוד בתמונה
-Negative: הצגת התמונה בצבעים מנוגדים
-Contrast: הגברת ניגודיות
-Sepia: הוספת גוונים חומים מדבריים לתמונה. על מנת לממש אפקט זה, ישנה נוסחה שאותה ניתן למצוא באינטרנט. 
-Ligher: הבהרת התמונה
-Darker: הפיכת התמונה לכהה יותר. 
-Vignette: אפקט בו מרכז התמונה הוא בהיר, אבל ככל שמתקרבים יותר לקצוות, התמונה נעשית חשוכה יותר. 
-Add Noise: הוספת "רעש" לתמונה היא אפקט בו מבצעים מניפולציות אקראיות בערכי הפיקסלים, שמשווים לתמונה מראה מנומר. 
-Solarize: טכניקה שבה מבוצע היפוך חלקי של צבעי התמונה, שנמצאים מעל סף בהירות מסוים. 

ניתן לספק לתמונה מראה וינטג'י באמצעות מימוש של שתי מניפולציות יחדיו עליה: Sepia + Add Noise. הוסיפו גם את המניפולציה Vintage לאפשרויות. 


אינטראקציה עם העכבר: 
האפליקציה צריכה לאפשר למשתמש ליצור אינטראקציה עם התמונה באמצעות העכבר באחת משתי הדרכים הבאות (לבחירתכם): 
אפשרות 1: סימון ארבע נקודות
המשתמש יוכל ללחות על ארבע נקודות בתמונה כדי ליצור מרובע. 
נקודות אלה צריכות להיות מחוברות באופן ויזואלי עם קווים, כדי לציין את השטח שנבחר. 
המניפולציות שנבחרה צריכה להשפיע רק על השטח בתוך הריבוע הזה. שאר התמונה צריכה להישאר ללא שינוי. 
המשתמש צמריך להיות מסוגל לנקות את הנקודות שנבחרו ולהתחיל מחדש במידת הצורך. 

אפשרות 2: חלוקת התמונה
המשתמש יזיז את העכבר בציר ה-X (ימינה ושמאלה), כדי לחלק את התמונה לשני חלקים. 
החלק הימני של התמונה יישאר ללא שינוי, ואילו החלק השמאלי של התמונה יוצג לאחר שבוצעה עליו המניפולציה שנבחרה. 
בכל זמן נתון, אמור להיות מצויר על המסך קו אנכי במיקום X הנוכחי כדי לציין את החלוקה. 


