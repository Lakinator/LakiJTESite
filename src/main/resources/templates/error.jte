@import de.lakinator.lakijtesite.model.PageContext

@param PageContext pageContext

@template.layout(pageContext = pageContext,
content = @`
    <h1>Something went wrong! </h1>
    <h2>Our Engineers are on it</h2>
    <a href="/">Go Home</a>
`,
footer = null
)