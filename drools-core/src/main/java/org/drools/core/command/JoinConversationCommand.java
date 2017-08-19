package org.drools.core.command;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.drools.core.command.impl.ExecutableCommand;
import org.kie.api.runtime.Context;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class JoinConversationCommand<Void> implements ExecutableCommand<Void> {
    
    @XmlAttribute(required=true, name="conversation-id")
    private String conversationId;
    
    public JoinConversationCommand(){
        
    }

    public JoinConversationCommand(String conversationId) {
        this.conversationId = conversationId;
    }

    @Override
    public Void execute(Context context) {
        RequestContextImpl         reqContext = (RequestContextImpl)context;
        ConversationContextManager cvnManager = reqContext.getConversationManager();
        cvnManager.joinConversation(reqContext, conversationId);

        return (Void) null;
    }
}
