@import de.lakinator.lakijtesite.model.PageContext
@import de.lakinator.lakijtesite.model.VisitorInfo

@param PageContext pageContext
@param VisitorInfo visitorInfo

@template.layout(pageContext = pageContext,
content = @`
    <p>You are visitor number ${visitorInfo.count()}!</p>
`,
footer = @`
    <p>Thanks for visiting, come again soon!</p>
`
)