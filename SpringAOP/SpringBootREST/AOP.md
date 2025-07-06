# 🎬 AOP CONCEPTS IN A FILMY TWIST

---

### 1. *Join Point* (When)
Think of it as a **scene in the movie**.  
This is the part of your program's execution **where the action happens**!

---

### 2. *Advice* (What)
This is the **action**!  
It’s what happens **at a particular scene (Join Point)** — like a **plot twist** in your program’s flow.

---

### 3. *Aspect* (Where – Conceptual)
It’s the **script of your movie**.  
It defines what **plot twists (Advice)** happen and **where (Pointcut)**.

---

### 4. *Pointcut* (Where – Operational)
These are the **specific scenes (Join Points)** where the **plot twists (Advice)** occur.  
Think of it as a **bookmark in your script (Aspect)**.

---

### 5. *Target Object* (Whom)
This is the main character. It's the object that experiences the plot twists(Advice).

---

### 6. *Weaving* (How)
This is the director's job. It's how the script(Aspect) turns into a movie. In Spring AOP, this happens at runtime.

---

### 7. *Proxy* (The Double)
This is the stunt double in the movie.
This is the object created after applying the advice to the target object. It is the one that takes the hits, performs the stunts, and makes the main character(Target Object) look good.

---

### 8. *Type of Advice* (The Genre)
This can be before, after, around etc.