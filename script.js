const root=document.getElementById("tool-content");

const tools={
calculator:{
kicker:"CORE JAVA • OPERATORS",title:"Smart Calculator",copy:"Practice arithmetic operators with safe division and remainder handling.",
html:()=>`<div class="form-grid"><div class="field"><label>FIRST NUMBER</label><input id="a" type="number" value="24"></div><div class="field"><label>SECOND NUMBER</label><input id="b" type="number" value="6"></div><div class="field"><label>OPERATOR</label><select id="op"><option>+</option><option>-</option><option>*</option><option>/</option><option>%</option></select></div></div><button class="action" onclick="runCalculator()">Calculate result</button><div id="result"></div>`,
run(){const a=+document.getElementById("a").value,b=+document.getElementById("b").value,op=document.getElementById("op").value;let v;if((op==="/"||op==="%")&&b===0)return show("Error: Cannot divide by zero.","error");if(op==="+")v=a+b;if(op==="-")v=a-b;if(op==="*")v=a*b;if(op==="/")v=a/b;if(op==="%")v=a%b;show(v)}
},
analyzer:{
kicker:"CORE JAVA • CONDITIONS",title:"Number Analyzer",copy:"See how conditions classify a number by sign, parity, and primality.",
html:()=>`<div class="field"><label>INTEGER</label><input id="n" type="number" value="17"></div><button class="action" onclick="runAnalyzer()">Analyze number</button><div id="result"></div>`,
run(){const n=+document.getElementById("n").value;const sign=n>0?"Positive":n<0?"Negative":"Zero";const parity=n%2===0?"Even":"Odd";show(`<div class="label">Analysis</div><div class="value">${sign} • ${parity} • ${isPrime(n)?"Prime":"Not Prime"}</div>`)}
},
prime:{
kicker:"CORE JAVA • LOOPS",title:"Prime Checker",copy:"Use the same divisibility logic as the Java console implementation.",
html:()=>`<div class="field"><label>INTEGER</label><input id="n" type="number" value="97"></div><button class="action" onclick="runPrime()">Check primality</button><div id="result"></div>`,
run(){const n=+document.getElementById("n").value;show(`${n} is ${isPrime(n)?"a prime":"not a prime"} number.`)}
},
leap:{
kicker:"CORE JAVA • LOGIC",title:"Leap Year Detector",copy:"Apply the Gregorian leap-year rule using boolean logic.",
html:()=>`<div class="field"><label>YEAR</label><input id="year" type="number" value="2028"></div><button class="action" onclick="runLeap()">Check year</button><div id="result"></div>`,
run(){const y=+document.getElementById("year").value;const leap=y%400===0||(y%4===0&&y%100!==0);show(`${y} is ${leap?"a leap":"not a leap"} year.`)}
},
compare:{
kicker:"CORE JAVA • CONDITIONS",title:"Compare Numbers",copy:"Find the largest value using straightforward conditional logic.",
html:()=>`<div class="form-grid"><div class="field"><label>FIRST</label><input id="a" type="number" value="42"></div><div class="field"><label>SECOND</label><input id="b" type="number" value="87"></div><div class="field"><label>THIRD</label><input id="c" type="number" value="31"></div></div><button class="action" onclick="runCompare()">Find largest</button><div id="result"></div>`,
run(){const v=[+a.value,+b.value,+c.value];show(`Largest number: ${Math.max(...v)}`)}
},
addition:{
kicker:"CORE JAVA • VARIABLES",title:"Quick Addition",copy:"A tiny exercise for variables, input, and arithmetic operators.",
html:()=>`<div class="form-grid"><div class="field"><label>FIRST NUMBER</label><input id="a" type="number" value="18"></div><div class="field"><label>SECOND NUMBER</label><input id="b" type="number" value="24"></div></div><button class="action" onclick="runAddition()">Add numbers</button><div id="result"></div>`,
run(){show(`Result: ${+a.value + +b.value}`)}
}
};

function isPrime(n){if(n<=1||!Number.isInteger(n))return false;for(let i=2;i*i<=n;i++)if(n%i===0)return false;return true}
function show(value,type="success"){const el=document.getElementById("result");el.className="result "+type;el.innerHTML=typeof value==="string"&&value.includes("<")?value:`<div class="label">Output</div><div class="value">${value}</div>`}
function render(name){const t=tools[name];root.innerHTML=`<div class="tool-head"><div><div class="tool-kicker">${t.kicker}</div><h2 class="tool-title">${t.title}</h2><p class="tool-copy">${t.copy}</p></div><div class="badge">WEB DEMO</div></div>${t.html()}`}
function selectTool(name){document.querySelectorAll(".nav").forEach(n=>n.classList.toggle("active",n.dataset.tool===name));render(name);document.querySelector(".workspace").scrollIntoView({behavior:"smooth",block:"center"})}
function runCalculator(){tools.calculator.run()}function runAnalyzer(){tools.analyzer.run()}function runPrime(){tools.prime.run()}function runLeap(){tools.leap.run()}function runCompare(){tools.compare.run()}function runAddition(){tools.addition.run()}
render("calculator");
