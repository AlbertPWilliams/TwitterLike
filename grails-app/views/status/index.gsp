<html>
<head>
    <meta name="layout" content="main" />
    <title>What Are You Doing?</title>
	<g:javascript library="jquery" plugin="jquery" />
</head>
<body>
    <h1>Give your status</h1>
    <div class="updateStatusForm">
        <g:formRemote onSuccess="document.getElementById('messageArea').value='';" url="[action: 'updateStatus']" update="messageLists" name="updateStatusForm">
            <g:textArea name="message" value="" id="messageArea" /><br/>
            <g:submitButton name="Submit Status" />
        </g:formRemote>
    </div>
    <div id="messageLists">
    	<g:render template="messages" collection="${messages}" var="message"/>
	</div>
	<h1>People you can follow:</h1>
       <g:each var="person" in="${pers}">
       	<div id="name">
           	${person.realName} <g:link id="${person.id}" action="follow" controller="status">follow</g:link>
           </div>
       </g:each>
</body>
</html>