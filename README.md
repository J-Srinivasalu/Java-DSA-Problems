# Java-DSA-Questions
<p>
  <ol>
    <li class="collapsible"><a href="https://github.com/J-Srinivasalu/Java-DSA-Questions/tree/main/Basics%20of%20Programming(Java)">Basics of programming(Java)</a></li>
    <ul class="content">
      <li>input/output</li>
      <li>conditional statements</li>
      <li>Loops</li>
    </ul>
    <li>Functions</li>
    <ul>
      <li>Scoping</li>
      <li>Variable Length Arguments</li>
    </ul>
    <li>Arrays</li>
    <ul>
      <li>Searching</li>
      <li>Sorting</li>
    </ul>
  </ol>
</p>

<style>
/* Style the button that is used to open and close the collapsible content */
.collapsible {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}

/* Add a background color to the button if it is clicked on (add the .active class with JS), and when you move the mouse over it (hover) */
.active, .collapsible:hover {
  background-color: #ccc;
}
  .collapsible:after {
  content: '\02795'; /* Unicode character for "plus" sign (+) */
  font-size: 13px;
  color: white;
  float: right;
  margin-left: 5px;
}

.active:after {
  content: "\2796"; /* Unicode character for "minus" sign (-) */
}

/* Style the collapsible content. Note: hidden by default */
.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
</style>

<script>
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.maxHeight){
      content.style.maxHeight = null;
    } else {
      content.style.maxHeight = content.scrollHeight + "px";
    }
  });
}
</script>
